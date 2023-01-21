import React from "react";

function PrimaryButton({ text = "", trailingIcon, onClick, className }, props) {
    return (
        <button
            className={
                "bg-primary text-white border-2 border-black black-shadow rounded-lg hover:from-secondary hover:to-primary hover:bg-gradient-radial transition-all " +
                className
            }
            onClick={onClick}
        >
            <div className="px-[12px] py-[6px] flex justify-between items-center gap-x-2">
                <p className="text-white text-center w-full">{text}</p>
                {trailingIcon}
            </div>
        </button>
    );
}

export default PrimaryButton;
