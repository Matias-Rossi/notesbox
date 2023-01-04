import React from 'react'
import MusicalBoxCard from './MusicalBoxCard'

function MusicalBoxGrid({boxes, className}) {
  return (
    <div className={"grid grid-cols-3 gap-x-12 gap-y-14 " + className}>
        {boxes.map((b, i) => 
            <MusicalBoxCard box={b} key={i}/>
        )}
    </div>
  )
}

export default MusicalBoxGrid