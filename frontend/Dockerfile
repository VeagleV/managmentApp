FROM node:18-alpine AS builder

WORKDIR /app
COPY package*.json ./


RUN npm install -g @vue/cli && \
    npm install --unsafe-perm && \
    chmod -R 755 node_modules/

COPY . .


RUN npx vue-cli-service build

FROM nginx:alpine
COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]