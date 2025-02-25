import { createRouter, createWebHistory } from "vue-router";
import RegisterPage from "@/components/RegisterPage.vue";
import LoginPage from "@/components/LoginPage.vue";
import VerifyAccountPage from "@/components/VerifyAccountPage.vue";
import RegistrationSuccess from "@/components/RegistrationSuccess.vue";
import LandingPage from "@/components/LandingPage.vue";

const routes = [
  { path: "/register", component: RegisterPage },
  { path: "/login", component: LoginPage },
  { path: "/verify", name: "VerifyAccount", component: VerifyAccountPage },
  {
    path: "/registration-success",
    name: "RegistrationSuccess",
    component: RegistrationSuccess,
  },
  {
    path: "/",
    name: "Home",
    component: LandingPage,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
