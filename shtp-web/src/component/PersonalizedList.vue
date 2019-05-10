<template>
  <div class="categoryPageDiv">
    <div class="categoryProducts">
      <div class="productUnit"
           v-for="unit in units"
           v-show="currentUser.id==unit.userid"
           :key="unit.id">
        <div class="productUnitFrame" >
          <span class="productPicture"><img :src="unit.imageUrl" width="100px" class="productImage" /></span>
          <span class="productPrice">¥{{unit.price}}</span>
          <span class="productLink">{{unit.description}}</span>
          <div>
            <img :src="unit.userface" class="userfaceImg"/>
            <div class="productOwner">{{unit.name}}</div>
            <i class="el-icon-edit" @click="editProduct(unit)"></i>
            <i class="el-icon-delete" @click="deleteProduct(unit.id)"></i>
          </div>

        </div>
      </div>
      <div style="clear:both"></div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "PersonalizedList",
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
        })
      },
      editProduct(unit){
        this.$router.push({
          path: `/updateProduct`,
          query: {
            id: unit.id,
            price: unit.price,
            description: unit.description,
            avatar: unit.imageUrl
          }
        })
      },
      deleteProduct(id){
        this.deleteRequest('/product/unit/deleteProduct/' + id).then(()=>{
          alert("删除成功");
          window.location.reload();
        })
      }
    },
    mounted: function () {
      this.loadProducts()
    }
  }
</script>

<style scoped>
  @import "../styles/productUnit.css";
</style>
