{\rtf1\ansi\ansicpg1252\cocoartf2511
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\froman\fcharset0 Times-Roman;\f1\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;\red148\green6\blue75;\red255\green255\blue255;\red38\green38\blue38;
\red132\green134\blue132;\red14\green114\blue164;\red19\green36\blue126;}
{\*\expandedcolortbl;;\cssrgb\c65490\c11373\c36471;\cssrgb\c100000\c100000\c100000;\cssrgb\c20000\c20000\c20000;
\cssrgb\c58824\c59608\c58824;\cssrgb\c0\c52549\c70196;\cssrgb\c9412\c21176\c56863;}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc0\levelnfcn0\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{decimal\}}{\leveltext\leveltemplateid1\'01\'00;}{\levelnumbers\'01;}\fi-360\li720\lin720 }{\listname ;}\listid1}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}}
\margl1440\margr1440\vieww36740\viewh16700\viewkind0
\deftab720
\pard\tx220\tx720\pardeftab720\li720\fi-720\partightenfactor0
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 \cb3 i\expnd0\expndtw0\kerning0
mport\cf4  time
\f1\fs29\fsmilli14667 \
\pard\tx220\tx720\pardeftab720\li720\fi-720\partightenfactor0
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 import\cf4  board
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 import\cf4  busio
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 import\cf4  adafruit_tmp007
\f1\fs29\fsmilli14667 \
\
\pard\tx220\tx720\pardeftab720\li720\fi-720\partightenfactor0
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf5 # Define a function to convert celsius to fahrenheit.
\f1\fs29\fsmilli14667 \cf4 \
\pard\tx220\tx720\pardeftab720\li720\fi-720\partightenfactor0
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 def\cf4  c_to_f(c):
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 return\cf4  c * \cf6 9.0\cf4  / \cf6 5.0\cf4  + \cf6 32.0
\f1\fs29\fsmilli14667 \cf4 \
\
\pard\tx220\tx720\pardeftab720\li720\fi-720\partightenfactor0
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf5 # Create library object using our Bus I2C port
\f1\fs29\fsmilli14667 \cf4 \
\pard\tx220\tx720\pardeftab720\li720\fi-720\partightenfactor0
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf4 i2c = busio.I2C(board.SCL, board.SDA)
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 sensor = adafruit_tmp007.TMP007(i2c)
\f1\fs29\fsmilli14667 \
\
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 while\cf4  \cf2 True\cf4 :
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 die_temp = sensor.die_temperature
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 print\cf4 (\cf7 ' Die temperature: \{0:0.3F\}*C / \{1:0.3F\}*F'\cf4 .format(die_temp, c_to_f(die_temp)))
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 obj_temp = sensor.temperature
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 \cf2 print\cf4 (\cf7 'Object temperature: \{0:0.3F\}*C / \{1:0.3F\}*F'\cf4 .format(obj_temp, c_to_f(obj_temp)))
\f1\fs29\fsmilli14667 \
\ls1\ilvl0
\f0\fs26\fsmilli13333 time.sleep(\cf6 5.0\cf4 )}