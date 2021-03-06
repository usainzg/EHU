cmake_minimum_required(VERSION 3.9)
project(Plantilla1718)

set(CMAKE_CXX_STANDARD 11)

add_executable(Plantilla1718
        build/Fondo.h
        build/soundbank_bin.h
        gfx/Fondo.grit
        gfx/Fondo.png
        include/defines.h
        include/fondos.h
        include/nds.h
        include/rutservs.h
        include/sprites.h
        include/teclado.h
        include/temporizadores.h
        nds/arm7/aes.h
        nds/arm7/audio.h
        nds/arm7/clock.h
        nds/arm7/codec.h
        nds/arm7/i2c.h
        nds/arm7/input.h
        nds/arm7/sdmmc.h
        nds/arm7/serial.h
        nds/arm7/touch.h
        nds/arm9/background.h
        nds/arm9/boxtest.h
        nds/arm9/cache.h
        nds/arm9/cache_asm.h
        nds/arm9/console.h
        nds/arm9/decompress.h
        nds/arm9/dldi.h
        nds/arm9/dldi_asm.h
        nds/arm9/dynamicArray.h
        nds/arm9/exceptions.h
        nds/arm9/guitarGrip.h
        nds/arm9/image.h
        nds/arm9/input.h
        nds/arm9/keyboard.h
        nds/arm9/linkedlist.h
        nds/arm9/math.h
        nds/arm9/nand.h
        nds/arm9/ndsmotion.h
        nds/arm9/paddle.h
        nds/arm9/pcx.h
        nds/arm9/piano.h
        nds/arm9/postest.h
        nds/arm9/rumble.h
        nds/arm9/sassert.h
        nds/arm9/sound.h
        nds/arm9/sprite.h
        nds/arm9/trig_lut.h
        nds/arm9/video.h
        nds/arm9/videoGL.h
        nds/arm9/window.h
        nds/asminc.h
        nds/bios.h
        nds/card.h
        nds/debug.h
        nds/disc_io.h
        nds/dma.h
        nds/fifocommon.h
        nds/fifomessages.h
        nds/input.h
        nds/interrupts.h
        nds/ipc.h
        nds/jtypes.h
        nds/memory.h
        nds/ndstypes.h
        nds/registers_alt.h
        nds/rsa.h
        nds/sha1.h
        nds/system.h
        nds/timers.h
        nds/touch.h
        source/fondos.c
        source/graficos.c
        source/main.c
        source/rutserv.c
        source/sprites.c
        source/teclado.c
        source/temporizadores.c
        Makefile)
