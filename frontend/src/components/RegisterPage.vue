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
