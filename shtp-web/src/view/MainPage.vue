<template>
  <div class="publicback">
    <SearchEngine></SearchEngine>
    <span class="seg">最新</span>
    <ProductList></ProductList>
  </div>
</template>

<script>
  import SearchEngine from "../component/SearchEngine";
  import ProductList from "../component/ProductList";
  export default {
    name: "MainPage",
    components: {ProductList, SearchEngine}
  }
</script>

<style scoped>
  @import "../styles/public.css";
  @import "../styles/seg.css";
</style>
