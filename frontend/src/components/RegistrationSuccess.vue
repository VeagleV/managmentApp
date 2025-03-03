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
