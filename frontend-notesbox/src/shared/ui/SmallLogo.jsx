import React from 'react'

function SmallLogo() {
    const style = {
        backgroundImage: `url(../src/assets/brand/notesbox-logo.png)`,
        backgroundSize: "contain",
        backgroundRepeat: "no-repeat",
        width: "100%",
        height: "0",
        paddingTop: "30.22%"

    }
  return (
    <div style={style} />
  )
}

export default SmallLogo