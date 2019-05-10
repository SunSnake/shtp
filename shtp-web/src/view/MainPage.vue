<template>
  <div class="publicback">
    <div class="searchDiv">
      <el-form :model="searchForm">
        <el-form-item>
          <el-input v-model="searchForm.words" placeholder="请输入内容" prefix-icon="el-icon-search" class="searchInput" ref="words"></el-input>
          <el-button type="primary" @click="postSearch">搜索</el-button>
          <el-button @click="returnMain" style="margin-left: 0px">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="seg">最新</div>
    <div class="categoryPageDiv" v-if="showSearch">
      <div class="categoryProducts">
        <div class="productUnit"
             v-for="unit in units"
             :key="unit.id">
          <div class="productUnitFrame" >
            <span class="productPicture"><img :src="unit.imageUrl" width="100px" class="productImage" /></span>
            <span class="productPrice">¥{{unit.price}}</span>
            <span class="productLink">{{unit.description}}</span>
            <a @click="goUser"><div><img :src="unit.userface" class="userfaceImg"/><div class="productOwner">{{unit.name}}</div></div></a>
          </div>
        </div>
        <div style="clear:both"></div>
      </div>
    </div>
    <ProductList v-else></ProductList>
  </div>
</template>

<script>
  import ProductList from "../component/ProductList";
  export default {
    name: "MainPage",
    components: {ProductList},
    data(){
      return {
        searchForm:{
          words: '',
        },
        showSearch: false,
        units: ''
      }
    },
    methods:{
      returnMain(){
        this.$refs.words.value = '';
        this.showSearch = false;
      },
      postSearch(){
        if (this.$refs.words.value) {
          let _this = this;
          this.postRequest('/search/unit/searchPost', this.searchForm).then(resp=> {
            if (resp&&resp.status==200){
              _this.units = resp.data;
              _this.showSearch = true;
              _this.clearInput();
            } else {
              alert("未知错误")
            }
          });
        } else {
          this.$alert('请输入搜索内容', '提示', {
            confirmButtonText: '确定',
            type: 'warning'
          });
        }
      },
      clearInput(){
        this.$refs.words.value = ''
      },
    }
  }
</script>

<style scoped>
  @import "../styles/public.css";
  @import "../styles/seg.css";
  @import "../styles/productUnit.css";

  .searchDiv{
    width: 600px;
    margin: 150px auto 50px auto;
  }
  .searchInput{
    width: 450px;
  }
</style>
