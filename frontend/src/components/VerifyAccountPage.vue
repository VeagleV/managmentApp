<template>
  <div class="auth-page">
    <div class="container">
      <h2>Подтверждение аккаунта</h2>
      <p v-if="loading">Проверка токена...</p>
      <p v-else-if="success">Аккаунт успешно подтвержден!</p>
      <p v-else>Неверный или просроченный токен.</p>
    </div>
  </div>
</template>

<script>
import axios from "@/services/apiClient";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

export default {
  name: "VerifyAccountPage",
  setup() {
    const loading = ref(true);
    const success = ref(false);
    const route = useRoute();

    onMounted(async () => {
      const token = route.query.token;
      if (token) {
        try {
          const response = await axios.get(`/auth/verify?token=${token}`);
          success.value = true;
          console.log(response.data);
        } catch (error) {
          console.error("Ошибка при подтверждении аккаунта:", error);
        }
      }
      loading.value = false;
    });

    return { loading, success };
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
body {
  background: linear-gradient(135deg, #6a11cb, #2575fc);
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.auth-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
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
