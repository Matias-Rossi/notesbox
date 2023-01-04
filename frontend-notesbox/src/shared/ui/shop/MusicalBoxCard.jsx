import React from "react";
import PrimaryButton from "../input/PrimaryButton";
import PlayPauseButton from "../input/PlayPauseButton";
import { FaShoppingCart } from "react-icons/fa";
import { Link } from "react-router-dom";

function MusicalBoxCard({ box, className }) {
  return (
    <div className={"flex flex-col black-shadow border-2 border-black rounded-lg relative w-56 " + className }>
      <div className="px-[18px] pt-2 pb-6">
        <Link>
          {/* TODO: Add hyperlink */}
          <h5>{box.displayName}</h5>
        </Link>
        <div className="flex justify-between">
          <h5 className="text-base">{`\$${box.price}`}</h5>
          {/* TODO: Add discount */}
          <p>{box.categoryDisplayName}</p>
        </div>
      </div>
      {/* Buttons */}
      <div className="flex justify-around absolute w-full -bottom-5 px-2">
        <PlayPauseButton />
        <PrimaryButton text="Add to Cart" trailingIcon={<FaShoppingCart />} />
      </div>
    </div>
  );
}

export default MusicalBoxCard;
