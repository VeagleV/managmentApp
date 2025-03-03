import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "./assets/styles.css";

document.title = "GoalHub: Envision. Execute. Excel.";
createApp(App).use(router).mount("#app");
