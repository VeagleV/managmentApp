# Этап 1: Сборка приложения
FROM node:18-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Этап 2: Размещение статических файлов на Nginx
FROM nginx:alpine
COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
RUN ls /usr/share/nginx/html 
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]