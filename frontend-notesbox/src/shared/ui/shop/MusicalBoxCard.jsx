import React from "react";
import PrimaryButton from "../input/PrimaryButton";
import PlayPauseButton from "../input/PlayPauseButton";
import { FaShoppingCart } from "react-icons/fa";
import { Link } from "react-router-dom";

function MusicalBoxCard({ box, className }) {
  return (
    <div className={"flex flex-col black-shadow border-2 border-black rounded-lg relative w-56 " + className}>
      <div className="px-[18px] pt-2 pb-6 flex flex-col justify-between h-full">
        <Link>
          {/* TODO: Add hyperlink */}
          <h5>{box.displayName}</h5>
        </Link>
        <div className="flex justify-between">
          <PriceLabel box={box} />
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


function PriceLabel({ box }) {
  if (box.discountPrice) {
    return (
      <div className="flex">
        <div className="flex justify-start items-center gap-2">
          <h5 className="text-base text-black">{`\$${box.discountPrice}`}</h5>
          <h4 className="text-sm text-black-50 line-through">{`\$${box.price}`}</h4>
        </div>

      </div>
    )
  } else {

    return (
      <div className="flex">
        <h5 className="text-base">{`\$${box.price}`}</h5>
      </div>
    )
  }
}

export default MusicalBoxCard;
