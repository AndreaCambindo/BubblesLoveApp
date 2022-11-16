package com.example.bubblesloveapp.interfaces

import com.example.bubblesloveapp.data.models.PlanItemModel

interface OnPlanClickListener {
    fun onClick(item: PlanItemModel)
}