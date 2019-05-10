<template>
  <div class="publicback">
    <div class="upper">
      <el-form ref="form" :model="form" label-width="90px">
        <el-form-item label="添加描述：">
          <el-input type="textarea" v-model="form.description" :rows="8" ref="desc"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">发布</el-button>
          <el-button @click="clearInput">清除</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="seg">最新</div>
    <div class="abmsg">
      <el-row class="rowTitle">
        <el-col :span="5"><div class="grid-content bg-purple">日期</div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple-light">用户</div></el-col>
        <el-col :span="14">
          <div class="grid-content bg-purple">描述</div>
        </el-col>
      </el-row>
      <el-row v-for="(ask,index) in asks" :key="index" class="rowBottom">
        <el-col :span="5"><div class="grid-content bg-purple">{{ask.date}}</div></el-col>
        <el-col :span="5"><a @click="goUser(ask.userid)"><div class="grid-content bg-purple-light">{{ask.username}}</div></a></el-col>
        <el-col :span="14">
          <div class="grid-content bg-purple">
            {{ask.description}}
            <!--<el-button class="inline" v-show="(currentUser.name==ask.username)||(currentUser.name=='系统管理员')" @click="deleteMsg(ask.id)">删除</el-button>
            <el-button class="inline" v-show="(currentUser.name==ask.username)||(currentUser.name=='系统管理员')" @click="updateMsg(ask.id)">更新</el-button>-->
            <i class="el-icon-delete inline" @click="deleteMsg(ask.id)" v-show="(currentUser.name==ask.username)||(currentUser.name=='系统管理员')"></i>
            <i class="el-icon-edit inline" @click="updateMsg(ask.id)" v-show="(currentUser.name==ask.username)||(currentUser.name=='系统管理员')"></i>
          </div>

        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Askbuy',
    data() {
      return {
        form: {
          date: this.formatDate(),
          username: this.$store.state.user.name,
          description: ''
        },
        asks: [],
        currentUser: this.$store.state.user,
      }
    },
    methods: {
      goUser(userid){
        let _this = this;
        if (this.$store.state.user.id == userid) {

        } else {
          this.postRequest('/system/user/addFriend', {
            cuid: this.$store.state.user.id,
            userid: userid
          }).then(()=> {
            _this.$router.push({path: '/chat'});
          });
        }
      },
      deleteMsg(id){
        this.deleteRequest('/askbuy/unit/deleteAskBuy/' + id).then(()=>{
          alert("删除成功");
          window.location.reload();
        })
      },
      updateMsg(id){
        this.$prompt('请输入描述修改', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          this.$message({
            type: 'success',
            message: '修改成功 '
          });
          this.putRequest('/askbuy/unit/updateAskBuy', {
            date: this.formatDate(),
            id: id,
            description: value
          }).then(()=>{
            alert("更新成功");
            window.location.reload();
          })
        });
      },
      onSubmit(){
        if (this.$refs.desc.value) {
          let _this = this;
          this.postRequest('/askbuy/unit/postAskBuy', this.form).then(resp=> {
            if (resp&&resp.status==200){
              this.$alert('发布成功', '提示', {
                confirmButtonText: '确定',
                type: 'warning'
              }).then(()=>{
                _this.clearInput();
                window.location.reload();
              }).catch(()=>{
                _this.clearInput();
                window.location.reload();
              });
            } else {
              alert("未知错误")
            }
          });
        } else {
          this.$alert('请输入发布内容', '提示', {
            confirmButtonText: '确定',
            type: 'warning'
          });
        }
      },
      clearInput(){
        this.$refs.desc.value = ''
      },
      loadAskBuy(){
        let _this = this;
        this.getRequest('/askbuy/unit/loadAskBuy').then(resp=>{
          _this.asks = resp.data;
        });
      },
      formatDate() {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        if (month < 10) {
          month = "0" + month;
        }
        if (day < 10) {
          day = "0" + day;
        }
        if (hours < 10) {
          hours = "0" + hours;
        }
        if (minutes < 10) {
          minutes = "0" + minutes;
        }
        return year + "-" + month + "-" + day + " " + hours + ":" + minutes;
      }
    },
    mounted:function () {
      this.loadAskBuy();
    }
  }
</script>

<style>
  @import "../styles/public.css";
  @import "../styles/seg.css";
  @import "../styles/upperDiv.css";
  .inline{
    float: right;
    margin-right: 10px;
    margin-top: 8px;
    /*margin-top: -8px;*/
  }
  .abmsg{
    padding-left: 20px;
    margin-top: 15px;
  }
  .rowTitle{
    font-size: 20px;
    font-weight: bolder;
    font-family: Arial;
    border-bottom: #C40000 2px solid;
  }
  .rowBottom{
    border-bottom: white 1px solid;
    font-size: 15px;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
    padding-top: 12px;
  }
  .bg-purple {
    background: #d3dce6;
    padding-top: 12px;
  }
  .bg-purple-light {
    background: #e5e9f2;
    padding-top: 12px;
  }
</style>
