function PlayerList({ players, onEdit, onDelete }) {
  if (players.length === 0) {
    return <p>No players found. Add one using the form.</p>;
  }

  return (
    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Role</th>
          <th>Matches</th>
          <th>Team</th>
          <th>Country</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {players.map((player) => (
          <tr key={player.playerId}>
            <td>{player.jerseyNumber}</td>
            <td>{player.playerName}</td>
            <td>
              <span className={`role-badge role-${player.role.replace(" ", "")}`}>
                {player.role}
              </span>
            </td>
            <td>{player.totalMatches}</td>
            <td>{player.teamName}</td>
            <td>{player.countryName}</td>
            <td className="actions-cell">
              <button onClick={() => onEdit(player)}>Edit</button>
              <button className="danger" onClick={() => onDelete(player.playerId)}>
                Delete
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default PlayerList;