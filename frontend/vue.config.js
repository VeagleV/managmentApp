const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8080", // URL вашего бэкенда
        changeOrigin: true,
        pathRewrite: { "^/api": "" }, // Убираем префикс /api из пути
      },
    },
  },
});
