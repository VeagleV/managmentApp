<template>
  <div class="welcome-page">
    <!-- Шапка -->
    <header class="header">
      <div class="container">
        <div class="header-content">
          <h1 class="logo">TaskFlow</h1>
          <nav class="navbar">
            <button class="cta-button secondary-button" @click="goToLogin">
              Войти
            </button>
            <button class="cta-button" @click="goToRegister">
              Зарегистрироваться
            </button>
          </nav>
        </div>
      </div>
    </header>

    <!-- Основной контент -->
    <main class="hero">
      <div class="container">
        <div class="hero-content">
          <h2>Управляйте задачами легко и эффективно</h2>
          <p>
            TaskFlow — это мощный инструмент для управления проектами, который
            помогает командам достигать целей быстрее.
          </p>
          <div class="hero-buttons">
            <button class="cta-button" @click="goToRegister">
              Зарегистрироваться
            </button>
            <button class="cta-button secondary-button" @click="goToLogin">
              Войти
            </button>
          </div>
        </div>
      </div>
    </main>

    <!-- Подвал -->
    <footer class="footer">
      <div class="container">
        <p>&copy; 2025 TaskFlow. Все права защищены.</p>
      </div>
    </footer>
  </div>
</template>

<script>
import { useRouter } from "vue-router";

export default {
  name: "WelcomePage",
  setup() {
    const router = useRouter();

    const goToRegister = () => {
      router.push({ name: "Register" });
    };

    const goToLogin = () => {
      router.push({ name: "Login" });
    };

    return {
      goToRegister,
      goToLogin,
    };
  },
};
</script>
