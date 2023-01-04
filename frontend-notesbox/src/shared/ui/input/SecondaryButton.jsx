import React from 'react'

function SecondaryButton({text, trailingIcon, isBold = true, onClick}, props) {
    return (
        <button className='flex gap-2 items-center text-black' onClick={onClick}>
            <VerticalDivider/>
            <p className={`text-black ${isBold ? "font-bold" : "font-normal"}`}>{text}</p>
            {trailingIcon}
        </button>
    
      )
}

export default SecondaryButton

function VerticalDivider() {
    return(
        <div className='w-1 h-6 bg-secondary'/>
    );
}