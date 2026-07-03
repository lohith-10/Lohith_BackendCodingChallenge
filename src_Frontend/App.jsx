import { useEffect, useState } from "react";
import PlayerList from "./components/PlayerList";
import PlayerForm from "./components/PlayerForm";
import {
  getAllPlayers,
  getAllBowlers,
  addPlayer,
  updatePlayer,
  deletePlayer,
} from "./api/playerApi";

function App() {
  const [players, setPlayers] = useState([]);
  const [playerToEdit, setPlayerToEdit] = useState(null);
  const [showBowlersOnly, setShowBowlersOnly] = useState(false);

  useEffect(() => {
    loadPlayers();
  }, [showBowlersOnly]);

  function loadPlayers() {
    const request = showBowlersOnly ? getAllBowlers() : getAllPlayers();

    request
      .then((response) => setPlayers(response.data))
      .catch((error) => console.error("Failed to load players", error));
  }

  function handleSave(playerData) {
    const request = playerToEdit
      ? updatePlayer(playerToEdit.playerId, playerData)
      : addPlayer(playerData);

    return request
      .then(() => {
        setPlayerToEdit(null);
        loadPlayers();
      })
      .catch((error) => console.error("Failed to save player", error));
  }

  function handleEdit(player) {
    setPlayerToEdit(player);
  }

  function handleCancel() {
    setPlayerToEdit(null);
  }

  function handleDelete(playerId) {
    if (!window.confirm("Delete this player?")) return;

    deletePlayer(playerId)
      .then(() => loadPlayers())
      .catch((error) => console.error("Failed to delete player", error));
  }

  return (
    <div>
      <h1>🏏 Cricket Team Management</h1>

      <PlayerForm playerToEdit={playerToEdit} onSave={handleSave} onCancel={handleCancel} />

      <h2>Players</h2>
      <label>
        <input
          type="checkbox"
          checked={showBowlersOnly}
          onChange={(e) => setShowBowlersOnly(e.target.checked)}
        />
        Show bowlers only
      </label>

      <PlayerList players={players} onEdit={handleEdit} onDelete={handleDelete} />
    </div>
  );
}

export default App;