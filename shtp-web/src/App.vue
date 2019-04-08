<template>
  <div id="app">
    <NavMenu v-if="$route.meta.keepAlive"></NavMenu>
    <router-view/>
  </div>
</template>

<script>
  import NavMenu from "./component/NavMenu";
  export default {
    name: 'App',
    components: {NavMenu}
  }
</script>

<style>

</style>
