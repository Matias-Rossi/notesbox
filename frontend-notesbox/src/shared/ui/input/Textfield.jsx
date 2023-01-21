import React from 'react'

function Textfield({label, placeholder, type, name, id, className, width = false}) {
  if (id === undefined) {
    id = name;
  }
  
  return (
    <div className={`flex flex-col gap-1 ${width? width : "w-full"}`}>
        <label className={`font-bold sans text-black-75 ${label ? "" : "hidden"}`}>{label}</label>
        <input type={type} name={name} id={id} placeholder={placeholder} className={"bg-black-10 text-black sans py-2 px-3 rounded-lg "+className+" "+width }/>
    </div>
  )
}

export default Textfield