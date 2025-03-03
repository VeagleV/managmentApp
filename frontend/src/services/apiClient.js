// src/services/apiClient.js
import axios from "axios";

const apiClient = axios.create({
  baseURL: "/api", // Будет проксировано на http://localhost:8080 (бэкенд)
  headers: {
    "Content-Type": "application/json",
  },
});

export default apiClient;
