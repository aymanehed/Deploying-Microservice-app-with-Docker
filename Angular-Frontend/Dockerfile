FROM node:latest as build

WORKDIR /usr/local/app

COPY ./ /usr/local/app/
RUN npm install

RUN npm run build

from nginx:latest

COPY --from=build /usr/local/app/dist/angular-frontend/browser /usr/share/nginx/html

EXPOSE 80
