<template>
  <div class="welcome-page">
    <!-- Шапка -->
    <header class="header">
      <div class="container">
        <div class="header-content">
          <h1 class="logo">GoalHub</h1>
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
          <h2>GoalHub: Envision. Execute. Excel.</h2>
          <p>
            GoalHub — это мощный инструмент для управления задачами, который
            помогает вам ставить цели, достигать их и эффективно управлять
            процессом.
          </p>
          <div class="hero-buttons">
            <button class="cta-button" @click="goToRegister">
              Начать сейчас
            </button>
          </div>
        </div>
      </div>
    </main>

    <!-- Подвал -->
    <footer class="footer">
      <div class="container">
        <p>&copy; 2025 GoalHub. Все права защищены.</p>
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
