<template>
  <div class="auth-page">
    <div class="container">
      <h2>Вход</h2>
      <form @submit.prevent="auth">
        <div class="form-group">
          <label for="login">Логин</label>
          <input type="text" id="login" v-model="login" required />
        </div>
        <div class="form-group">
          <label for="password">Пароль</label>
          <input type="password" id="password" v-model="password" required />
        </div>
        <button type="submit" class="button">Войти</button>
        <p class="login-link">
          Нет аккаунта?
          <router-link to="/register">Зарегестрироваться</router-link>
        </p>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "@/services/apiClient";

export default {
  name: "LoginPage",
  data() {
    return {
      login: "",
      password: "",
    };
  },
  methods: {
    async auth() {
      try {
        const response = await axios.post("/auth/login", {
          login: this.login,
          password: this.password,
        });
        alert(response.data);
      } catch (error) {
        console.error("Ошибка при входе:", error);
        alert("Неверный логин или пароль");
      }
    },
  },
};
</script>
