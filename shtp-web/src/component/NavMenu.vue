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
      <el-menu-item index="1">主页</el-menu-item>
      <el-menu-item index="2">订单管理</el-menu-item>
      <el-menu-item index="3">消息中心</el-menu-item>
      <el-menu-item index="4">求购</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
    export default {
        name: 'NavMenu'
    }
</script>

<style>

</style>
