import React from 'react'

function Checkbox({name, id, label, textStyle}) {
  if (id === undefined) {
    id = name;
  }

  return (
    <div className="flex gap-2 justify-start items-center">
        <input type="checkbox" name={name} id={id} />
        <label htmlFor="{id}" className={'sans font-black-75 text-base ' + textStyle}>{label}</label>
    </div>
  )
}

export default Checkbox