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
        <el-col :span="14"><div class="grid-content bg-purple">描述</div></el-col>
      </el-row>
      <el-row v-for="(ask,index) in asks" :key="index" class="rowBottom">
        <el-col :span="5"><div class="grid-content bg-purple">{{ask.date}}</div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple-light">{{ask.username}}</div></el-col>
        <el-col :span="14"><div class="grid-content bg-purple">{{ask.description}}</div></el-col>
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
        asks: []
      }
    },
    methods: {
      onSubmit(){
        var _this = this;
        this.loading = true;
        this.postRequest('/askbuy/unit/postAskBuy', this.form).then(resp=> {
          _this.loading = false;
        });
      },
      clearInput(){
        this.$refs.desc.value = ''
      },
      loadAskBuy(){
        let _this = this;
        this.getRequest('/askbuy/unit/loadAskBuy').then(resp=>{
          _this.asks = resp.data;
        });
        //this.form.date=this.formatDate();
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
