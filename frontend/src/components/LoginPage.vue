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

<style scoped>
/* Общие настройки */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Arial", sans-serif;
}
.auth-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

body {
  background: linear-gradient(135deg, #6a11cb, #2575fc);
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.container {
  background: white;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
  width: 350px;
  text-align: center;
}

h2 {
  color: #333;
  font-size: 24px;
  margin-bottom: 20px;
}
.form-group {
  margin-bottom: 15px;
  text-align: left;
}
.form-group.error input {
  border-color: red;
}
label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
  color: #333;
}
input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background: #f9f9f9;
  color: #333;
  font-size: 16px;
  transition: background 0.3s ease;
}
input:focus {
  background: #fff;
  outline: none;
  border-color: #2575fc;
}
button {
  background: #2575fc;
  color: white;
  border: none;
  padding: 12px 20px;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  width: 100%;
  margin-bottom: 15px;
  text-decoration: none;
  display: inline-block;
  text-align: center;
  transition: background 0.3s ease;
}
button:hover {
  background: #1e51a8;
}
.error-message {
  color: red;
  font-size: 14px;
  margin-top: 5px;
}
.login-link {
  font-size: 14px;
  color: gray;
  margin-top: 10px;
}
.login-link a {
  color: #2575fc;
  text-decoration: none;
}
.login-link a:hover {
  text-decoration: underline;
}
</style>
