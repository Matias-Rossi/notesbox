import React from "react";
import { FaPause, FaPlay } from "react-icons/fa";

/* 
    TODO: Fix weird background clipping issue around border edges
*/

function PlayPauseButton({ playing = false, onClick }) {

  return (
    <button
      className="rounded-full h-10 w-10 gradient-bg flex items-center justify-center border-2 border-black black-shadow hover:text-lg"     
      onClick={() => onClick}
    >
      {playing ? (
        <FaPause className="text-med" />
      ) : (
        <FaPlay className="pl-0.5" />
      )}
    </button>
  );
}

export default PlayPauseButton;
