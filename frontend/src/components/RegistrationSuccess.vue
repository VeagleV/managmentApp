<template>
  <div class="auth-page">
    <div class="container">
      <h2>Регистрация завершена</h2>
      <p>Проверьте вашу почту {{ email }} для подтверждения аккаунта.</p>
      <p>
        Вы будете автоматически перенаправлены на страницу входа через
        {{ countdown }} сек.
      </p>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "RegistrationSuccess",
  setup() {
    const router = useRouter();
    const email = ref("");
    const countdown = ref(10);

    onMounted(() => {
      email.value = new URLSearchParams(window.location.search).get("email");
      const interval = setInterval(() => {
        countdown.value--;
        if (countdown.value <= 0) {
          clearInterval(interval);
          router.push("/login"); // Перенаправление на страницу входа
        }
      }, 1000);
    });

    return {
      email,
      countdown,
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
p {
  color: #555;
  font-size: 16px;
  margin-bottom: 10px;
}
</style>
