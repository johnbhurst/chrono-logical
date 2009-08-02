#!/bin/bash

function stdcrop() {
  convert images/$1.png -crop 440x200+0+200 images/$1-cropped.png
}

function bigcrop() {
  convert images/$1.png -crop 520x300+0+200 images/$1-cropped.png
}

stdcrop chrono-logical-grails-default-list
stdcrop chrono-logical-grails-default-create
stdcrop chrono-logical-grails-default-create-precision-day
stdcrop chrono-logical-grails-joda-time-list
bigcrop chrono-logical-grails-calendar-create


