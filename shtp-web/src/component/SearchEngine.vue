<template>
  <div class="searchDiv">
    <el-input v-model="input" placeholder="请输入内容" prefix-icon="el-icon-search" class="searchInput"></el-input>
    <el-button type="primary">搜索</el-button>
  </div>
</template>

<script>
    export default {
      name: "SearchEngine",
      data(){
        return {
          input: ''
        }
      }
    }
</script>

<style>
  .searchDiv{
    width: 600px;
    margin: 150px auto 50px auto;
  }
  .searchInput{
    width: 500px;
  }
</style>
