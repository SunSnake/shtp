<template>
  <div class="publicback">
    <div class="upper">
      <el-form ref="form" :model="form" label-width="90px">
        <el-form-item label="添加描述：">
          <el-input type="textarea" v-model="form.desc" :rows="8"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">发布</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="seg">最新</div>
    <div class="abmsg">
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="date" label="日期" width="180"></el-table-column>
        <el-table-column prop="user" label="用户" width="180"></el-table-column>
        <el-table-column prop="detail" label="详细信息"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
    export default {
      name: 'Askbuy',
      data() {
        return {
          form: {
            name: '',
            desc: ''
          },
          tableData: [{
            date: '2016-05-02',
            user: '王小虎',
            detail: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-04',
            user: '王小虎',
            detail: '上海市普陀区金沙江路 1517 弄'
          }, {
            date: '2016-05-01',
            user: '王小虎',
            detail: '上海市普陀区金沙江路 1519 弄'
          }, {
            date: '2016-05-03',
            user: '王小虎',
            detail: '上海市普陀区金沙江路 1516 弄'
          }]
        }
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
</style>
