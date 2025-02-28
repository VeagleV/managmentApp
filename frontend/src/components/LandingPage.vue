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
        <div class="hero-image">
          <img
            src="https://via.placeholder.com/600x400"
            alt="Пример интерфейса TaskFlow"
          />
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

<style scoped>
/* Общие стили */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Arial", sans-serif;
}

body {
  background: linear-gradient(135deg, #6a11cb, #2575fc);
  color: #fff;
  line-height: 1.6;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

/* Шапка */
.header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  background-color: rgba(255, 255, 255, 0.7);
  z-index: 9999;
  transition: box-shadow 0.3s;
  backdrop-filter: blur(8px);
  -webkit-backdrop-filter: blur(8px);
}

.header-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
}

.logo {
  font-size: 28px;
  font-weight: bold;
  margin: 0;
}

.navbar {
  display: flex;
  gap: 15px;
  align-items: center;
}

.cta-button {
  background: #2575fc;
  color: white;
  border: none;
  padding: 12px 20px;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  transition: background 0.3s ease;
  height: 40px; /* Фиксированная высота кнопок */
  display: flex;
  align-items: center; /* Выравнивание текста внутри кнопок */
  justify-content: center;
}

.cta-button:hover {
  background: #1e51a8;
}

.secondary-button {
  background: #f0f0f0;
  color: #333;
}

.secondary-button:hover {
  background: #dcdcdc;
}

/* Герой */
.hero {
  background: linear-gradient(135deg, #6a11cb, #2575fc);
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 60px 0;
}

.hero-content {
  max-width: 50%;
}

.hero-content h2 {
  font-size: 48px;
  margin-bottom: 20px;
}

.hero-content p {
  font-size: 18px;
  margin-bottom: 30px;
}

.hero-buttons {
  display: flex;
  gap: 15px;
}

.hero-image img {
  max-width: 100%;
  height: auto;
  border-radius: 10px;
}

/* Подвал */
.footer {
  background: #2575fc;
  color: #fff;
  padding: 20px 0;
  text-align: center;
}
</style>
