<template>
  <div class="categoryPageDiv">
    <div class="categoryProducts">
      <div class="productUnit"
        v-for="unit in units"
        :key="unit.userid"
         ref="productUnit">
        <div class="productUnitFrame">
          <span class="productPicture"><img :src="unit.imageUrl" width="100px" class="productImage" /></span>
          <span class="productPrice">¥{{unit.price}}</span>
          <span class="productLink">{{unit.description}}</span>
          <div>
            <a @click="goUser(unit.userid)">
              <img :src="unit.userface" class="userfaceImg"/>
              <div class="productOwner">{{unit.name}}</div>
            </a>
            <i class="el-icon-delete" @click="deleteProduct(unit.id)" v-show="currentUser.name=='系统管理员'"></i>
          </div>
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
      goUser(id){
        let _this = this;
        if (this.$store.state.user.id == id) {

        } else {
          this.postRequest('/system/user/addFriend', {
            cuid: this.$store.state.user.id,
            userid: id
          }).then(()=> {
            _this.$router.push({path: '/chat'});
          });
        }
      },
      deleteProduct(id){
        this.deleteRequest('/product/unit/deleteProduct/' + id).then(()=>{
          alert("删除成功");
          window.location.reload();
        })
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
