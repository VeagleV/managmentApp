<template>
  <div class="auth-page">
    <div class="container">
      <h2>Регистрация</h2>
      <form @submit.prevent="register">
        <!-- Поле логина -->
        <div class="form-group" :class="{ error: errors.login }">
          <label for="login">Логин</label>
          <input type="text" id="login" v-model="login" required />
          <p v-if="errors.login" class="error-message">{{ errors.login }}</p>
        </div>

        <!-- Поле email -->
        <div class="form-group" :class="{ error: errors.email }">
          <label for="email">Email</label>
          <input type="email" id="email" v-model="email" required />
          <p v-if="errors.email" class="error-message">{{ errors.email }}</p>
        </div>

        <!-- Поле пароля -->
        <div class="form-group" :class="{ error: errors.password }">
          <label for="password">Пароль</label>
          <input type="password" id="password" v-model="password" required />
          <p v-if="errors.password" class="error-message">
            {{ errors.password }}
          </p>
        </div>

        <!-- Кнопка регистрации -->
        <button type="submit" class="button">Зарегистрироваться</button>

        <!-- Ссылка на вход -->
        <p class="login-link">
          Уже есть аккаунт? <router-link to="/login">Войти</router-link>
        </p>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "@/services/apiClient";
import { ref } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "RegisterPage",
  setup() {
    const router = useRouter();
    const login = ref("");
    const email = ref("");
    const password = ref("");
    const errors = ref({});

    const register = async () => {
      // Очистка ошибок перед отправкой запроса
      errors.value = {};

      try {
        const response = await axios.post("/auth/register", {
          login: login.value,
          email: email.value,
          password: password.value,
        });

        console.log(response.data);
        // Перенаправление на страницу уведомления
        await router.push({
          name: "RegistrationSuccess",
          query: { email: email.value },
        });
      } catch (error) {
        console.error("Ошибка при регистрации:", error);

        // Обработка ошибок от сервера
        if (error.response && error.response.data) {
          const serverErrors = error.response.data;
          errors.value = {
            login: serverErrors.login || "",
            email: serverErrors.email || "",
            password: serverErrors.password || "",
          };
        } else {
          errors.value = {
            general: "Произошла ошибка. Попробуйте позже.",
          };
        }
      }
    };

    return {
      login,
      email,
      password,
      errors,
      register,
    };
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
