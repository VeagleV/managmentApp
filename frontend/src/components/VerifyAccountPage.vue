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
