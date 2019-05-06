<template>
  <div class="categoryPageDiv">
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
</template>

<script>
  export default {
    name: "ProductList",
    data(){
      return{
        units: [],
        currentUser: this.$store.state.user,
      }
    },
    methods: {
      loadProducts(){
        let _this = this;
        this.getRequest('/product/unit/load').then(resp=>{
          _this.units = resp.data;
        });
      },
      goUser(){
        /*this.$router.push({path: '/askBuy'});*/
      }
    },
    mounted: function () {
      this.loadProducts();
    }
  }
</script>

<style>
  @import "../styles/productUnit.css";
</style>
