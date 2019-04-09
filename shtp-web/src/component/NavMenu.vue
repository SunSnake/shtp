<template>
  <div>
    <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1" @click="homePage">主页</el-menu-item>
      <el-menu-item index="2" @click="orderManagement">订单管理</el-menu-item>
      <el-menu-item index="3" @click="MsgCenter">消息中心</el-menu-item>
      <el-menu-item index="4" @click="Askbuy">求购</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
    export default {
      name: 'NavMenu',
      methods:{
        orderManagement: function () {
          this.$router.push('Order');
        },
        homePage: function () {
          this.$router.push('Home');
        },
        MsgCenter: function () {
          this.$router.push('MsgCenter');
        },
        Askbuy: function () {
          this.$router.push('Askbuy');
        }
      }
    }
</script>

<style>

</style>
