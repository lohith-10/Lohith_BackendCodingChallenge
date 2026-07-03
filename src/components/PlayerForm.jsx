import { useEffect, useState } from "react";

const emptyPlayer = {
  playerName: "",
  jerseyNumber: "",
  role: "Batsman",
  totalMatches: "",
  teamName: "",
  countryName: "",
  description: "",
};

function PlayerForm({ playerToEdit, onSave, onCancel }) {
  const [inputs, setInputs] = useState(emptyPlayer);

  useEffect(() => {
    if (playerToEdit) {
      setInputs(playerToEdit);
    } else {
      setInputs(emptyPlayer);
    }
  }, [playerToEdit]);

  function handleChange(e) {
    const { name, value } = e.target;
    setInputs((values) => ({ ...values, [name]: value }));
  }

  function handleSubmit(e) {
    e.preventDefault();
    onSave(inputs);
  }

  return (
    <form onSubmit={handleSubmit}>
      <h2>{playerToEdit ? "Edit Player" : "Add Player"}</h2>

      <label>
        Player Name
        <input type="text" name="playerName" value={inputs.playerName} onChange={handleChange} />
      </label>

      <label>
        Jersey Number
        <input type="number" name="jerseyNumber" value={inputs.jerseyNumber} onChange={handleChange} />
      </label>

      <label>
        Role
        <select name="role" value={inputs.role} onChange={handleChange}>
          <option value="Batsman">Batsman</option>
          <option value="Bowler">Bowler</option>
          <option value="Keeper">Keeper</option>
          <option value="All Rounder">All Rounder</option>
        </select>
      </label>

      <label>
        Total Matches
        <input type="number" name="totalMatches" value={inputs.totalMatches} onChange={handleChange} />
      </label>

      <label>
        Team Name
        <input type="text" name="teamName" value={inputs.teamName} onChange={handleChange} />
      </label>

      <label>
        Country
        <input type="text" name="countryName" value={inputs.countryName} onChange={handleChange} />
      </label>

      <label>
        Description
        <textarea name="description" value={inputs.description} onChange={handleChange} />
      </label>

      <button type="submit">{playerToEdit ? "Update Player" : "Add Player"}</button>
      {playerToEdit && (
        <button type="button" onClick={onCancel}>Cancel</button>
      )}
    </form>
  );
}

export default PlayerForm;