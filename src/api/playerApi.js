import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api/players",
});

export function getAllPlayers() {
  return api.get("/allplayers");
}

export function addPlayer(player) {
  return api.post("/add", player);
}

export function updatePlayer(playerId, player) {
  return api.put(`/${playerId}`, player);
}

export function deletePlayer(playerId) {
  return api.delete(`/${playerId}`);
}

export function getAllBowlers() {
  return api.get("/allbowlers");
}

export function getPlayerById(playerId) {
  return api.get(`/${playerId}`);
}

export default api;