import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails(props) {
  const { name, batch, status } = props;

  const headingStyle = {
    color: status.toLowerCase() === "ongoing" ? "green" : "blue",
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{name}</h3>
      <dl>
        <dt>Batch:</dt>
        <dd>{batch}</dd>
        <dt>Status:</dt>
        <dd>{status}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
