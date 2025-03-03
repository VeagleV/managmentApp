import { createRouter, createWebHistory } from "vue-router";
import RegisterPage from "@/components/RegisterPage.vue";
import LoginPage from "@/components/LoginPage.vue";
import RegistrationSuccess from "@/components/RegistrationSuccess.vue";
import VerifyAccountPage from "@/components/VerifyAccountPage.vue";
import LandingPage from "@/components/LandingPage.vue";

const routes = [
  { path: "/register", name: "Register", component: RegisterPage },
  { path: "/login", name: "Login", component: LoginPage },
  { path: "/verify", component: VerifyAccountPage },
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
