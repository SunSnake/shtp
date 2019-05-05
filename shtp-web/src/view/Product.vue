<template>
  <div class="publicback">
    <div class="upper">
      <el-form ref="productForm" :model="productForm" label-width="90px">
        <div class="description">
          <el-form-item label="商品描述：">
            <el-input type="textarea" v-model="productForm.description" :rows="8"></el-input>
          </el-form-item>
          <el-form-item label="商品价格：">
            <el-input v-model="productForm.price"></el-input>
          </el-form-item>
          <el-form-item label="图片路径：">
            <el-input
              v-model="productForm.imageUrl"
            ></el-input>
          </el-form-item>
        </div>
        <div class="pic">
          <!--<img id="portrait" style="width: 200px;height: 200px;background-color: #eeeeee"/>
          <input type="file" id="saveImage" accept="image/png,image/gif,image/jpeg" style="margin-left: 50px">-->
          <img :src="previewAvatar" style="width: 200px;height: 200px;background-color: #eeeeee"/>
          <input type="file" name="file" ref="upload" @change="getImg" accept="image/png,image/gif,image/jpeg" style="margin-left: 50px">
        </div>
        <el-form-item class="buttons">
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button>清除</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="seg">已发布</div>
    <PersonalizedList></PersonalizedList>
  </div>

</template>

<script>
    import PersonalizedList from "../component/PersonalizedList";
    export default {
      name: 'Product',
      components: {PersonalizedList},
      data() {
        return {
          productForm: {
            userId: this.$store.state.user.id,
            description: '',
            price: '',
            imageUrl: ''
          }
        };
      },

      mounted: function () {
        /*this.great();*/
      },
      methods: {
        onSubmit(){
          var _this = this;
          this.loading = true;
          this.postRequest('/product/unit/submit', this.productForm).then(resp=> {
            _this.loading = false;
          });
        },
        getImg(){
          var _this = this;
          this.productForm.imageUrl=window.URL.createObjectURL(_this.$refs.upload.files[0]);

          /*var _this = this;
          var imgFile = this.$refs.upload.files[0];
          var fr = new FileReader();
          fr.readAsDataURL(imgFile);
          fr.onload = function () {
            _this.productForm.imageUrl=fr.result;
          }
*/
        }
        /*great() {
          document.getElementById('saveImage').onchange = function () {
            var imgFile = this.files[0];
            var fr = new FileReader();
            var _this = this;
            fr.onload = function () {
              document.getElementById('portrait').src = fr.result;
            };
            fr.readAsDataURL(imgFile);
            this.productForm.imageUrl=document.getElementById('portrait').src;
          }
        },
        changeImage(e) {
          var file = e.target.files[0]
          var reader = new FileReader()
          var that = this
          reader.readAsDataURL(file)
          reader.onload = function (e) {
            that.avatar = this.result
          }
        }*/
      }
    }
</script>

<style scoped>
  @import "../styles/public.css";
  @import "../styles/seg.css";
  @import "../styles/upperDiv.css";

  .description{
    width: 700px;
  }
  .pic{
    position: relative;
    margin-left: 700px;
    margin-top: -264px;
  }

  .buttons{
    margin-top: 50px;
  }
</style>
