<template>
  <div class="publicback">
    <div class="lar">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="50px" class="demo-ruleForm">

        <el-form-item label="账号" label-width="80px" prop="username">
          <el-input v-model="ruleForm.username" autocomplete="on"></el-input>
        </el-form-item>

        <el-form-item label="密码" label-width="80px" prop="password">
          <el-input type="password" v-model="ruleForm.password" autocomplete="on"></el-input>
        </el-form-item>

        <div class="box">
          <div>
            <span class="lf" @click="clearCookie">忘记密码？</span>
            <span class="lf" @click="regeditAction">注册</span>
          </div>
          <div class="rf">
            <el-checkbox v-model="checked">一周内自动登录</el-checkbox>
          </div>
        </div>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" style="width:100%;">登录</el-button>
          <!--  <el-button @click="resetForm('ruleForm')">重置</el-button> -->
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
  export default {
    name: 'Login',
    data() {
      return {
        ruleForm: {
          username: '',
          password:''
        },
        rules: {
          username: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' }
          ]
        },
        checked: false

      };
    },
    //页面加载调用获取cookie值
    mounted() {
      this.getCookie();
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            const self = this;
            //判断复选框是否被勾选 勾选则调用配置cookie方法
            if (self.checked == true) {
              //传入账号名，密码，和保存天数3个参数
              self.setCookie(self.ruleForm.username, self.ruleForm.password, 7);
            }else {
              console.log("清空Cookie");
              //清空Cookie
              self.clearCookie();
            }
            alert('登录成功!');
            /*this.$router.push({ name: 'Mainpage',params:{user:self.ruleForm.username,pwd:self.ruleForm.password}});*/
            this.$router.push('Home');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      regeditAction:function() {
        this.$router.push('Regedit');
      },
      // resetForm(formName) {
      //   this.$refs[formName].resetFields();
      // },
      //设置cookie
      setCookie(c_name, c_pwd, exdays) {
        var exdate = new Date(); //获取时间
        exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays); //保存的天数
        //字符串拼接cookie
        window.document.cookie = "userName" + "=" + c_name + ";path=/;expires=" + exdate.toGMTString();
        window.document.cookie = "password" + "=" + c_pwd + ";path=/;expires=" + exdate.toGMTString();
      },
      //读取cookie
      getCookie: function() {
        if (document.cookie.length > 0) {
          var arr = document.cookie.split('; '); //这里显示的格式需要切割一下自己可输出看下
          for (var i = 0; i < arr.length; i++) {
            var arr2 = arr[i].split('='); //再次切割
            //判断查找相对应的值
            if (arr2[0] == 'userName') {
              //  console.log(arr2[1])
              this.ruleForm.username = arr2[1]; //保存到保存数据的地方
            } else if (arr2[0] == 'password') {
              // console.log(arr2[1])
              this.ruleForm.password = arr2[1];
            }
          }
          this.checked = true;
        }
      },
      //清除cookie
      clearCookie: function() {
        this.setCookie("", "", -1); //修改2值都为空，天数为负1天就好了
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  @import "../styles/public.css";
  @import "../styles/login.css";
  .lf{
    cursor: pointer;
    color: #f19149;
    font-size: 0.9rem;
  }
  .box{
    width: 350px;
    margin-left:50px;
    margin-bottom: 10px;
  }
  .rf{
    color:#a0a0a0;
  }
  /*.clearfix:after {
    content:".";
    height:0;
    visibility:hidden;
    clear:both;
  }*/
  /*.clearfix {
    *zoom:1;
  }*/
</style>
