import React from 'react'
import MusicalBoxCard from './MusicalBoxCard'

function MusicalBoxGrid({boxes, className}) {
  const style = {
    transition: "height 1s"
  }

  return (
    <div style={style} className={"grid grid-cols-3 gap-x-12 gap-y-14 md:grid-cols-2 md:gap-x-8 sm:grid-cols-1 " + className}>
        {boxes.map((b, i) => 
            <MusicalBoxCard box={b} key={i}/>
        )}
    </div>
  )
}

export default MusicalBoxGrid