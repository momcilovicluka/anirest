# anirest
![GitHub Repo stars](https://img.shields.io/github/stars/momcilovicluka/anirest?style=for-the-badge&color=0000ff) 
![GitHub last commit](https://img.shields.io/github/last-commit/momcilovicluka/anirest?style=for-the-badge&color=0000ff) 
![GitHub repo size](https://img.shields.io/github/repo-size/momcilovicluka/anirest?style=for-the-badge&color=0000ff)

REST api for anime. Faculty project for CBD/RZK

## Project Structure 📐
- **[Database](/Database)**: Database model & sql import 📂
- **[Properties](/Properties)**: Properties files for services 📃
- **[anime](/anime)**: Anime service - get anime info and add anime 📺 ↔ **[🐳 Docker Image](https://hub.docker.com/repository/docker/momcilovicluka/anirest-anime/general)**
- **[animeList](/animeList)**: Anime List service - get anime lists, create them and add anime to them 📺📃 ↔ **[🐳 Docker Image](https://hub.docker.com/repository/docker/momcilovicluka/anirest-anime-list/general)**
- **[api-gateway](/api-gateway)**: API gateway with security ⛓🔒 ↔ **[🐳 Docker Image](https://hub.docker.com/repository/docker/momcilovicluka/anirest-api-gateway/general)**
- **[config-server](/config-server)**: Managing properties for services 🛠 ↔ **[🐳 Docker Image](https://hub.docker.com/repository/docker/momcilovicluka/anirest-config-server/general)**
- **[naming-server](/naming-server)**: Eureka naming server 🗄 ↔ **[🐳 Docker Image](https://hub.docker.com/repository/docker/momcilovicluka/anirest-naming-server/general)**
- **[register](/register)**: Login/Register for users 👤 ↔ **[🐳 Docker Image](https://hub.docker.com/repository/docker/momcilovicluka/anirest-register/general)**
- **[tag](/tag)**: Tag service for detailed info about... you guessed it. Tags! 🏷️ ↔ **[🐳 Docker Image](https://hub.docker.com/repository/docker/momcilovicluka/anirest-tag/general)**
- **[anirest.postman_collection.json](https://www.postman.com/lukamomcilovic/workspace/anirest/collection/32372801-abd71715-5aad-4eba-9cd5-f6dff30ac14f)**: Import for testing with Postman ☑
- **[docker-compose](/docker-compose.yaml)**: Docker compose file - for runing with docker 🗃
- **[runAll.sh](runAll.sh)**: Script that allows easy startup of all necessary services ⏩

Feel free to explore and contribute to the project! If you have any suggestions or improvements, please open an issue or submit a pull request.
