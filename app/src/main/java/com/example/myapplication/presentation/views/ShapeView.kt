package com.example.myapplication.presentation.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.use
import androidx.core.view.isVisible
import com.example.domain.models.ShapeCategory
import com.example.myapplication.R
import com.example.myapplication.databinding.LayoutShapeViewBinding
import com.example.myapplication.presentation.dp2px
import com.google.android.material.shape.RelativeCornerSize

@SuppressLint("CustomViewStyleable")
class ShapeView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

	private val binding = LayoutShapeViewBinding.inflate(LayoutInflater.from(context), this)

	private val circleSize by lazy { context.dp2px(64f) }

	private val squareSize by lazy { context.dp2px(106f) }

	private val cornerRadius by lazy {
		context.resources.getDimensionPixelSize(R.dimen.margin8dp).toFloat()
	}

	init {
		with(binding) {
			context.obtainStyledAttributes(attrs, R.styleable.ShapeView).use { typedArray ->
				if (typedArray.getInt(R.styleable.ShapeView_shape, 0) == 0) {
					imageView.shapeAppearanceModel =
						imageView.shapeAppearanceModel.withCornerSize(RelativeCornerSize(0.5f))
					imageView.layoutParams.apply {
						width = circleSize
						height = circleSize
					}
				} else {
					imageView.layoutParams.apply {
						width = squareSize
						height = squareSize
					}
					imageView.shapeAppearanceModel =
						imageView.shapeAppearanceModel.withCornerSize(cornerRadius)
				}
			}
		}
	}

	fun setCategory(category: ShapeCategory) {
		resetState()
		with(binding) {
			title.text = category.name
			comingSoonIndicator.isVisible = category.isEmpty
		}
	}

	private fun resetState() {
		with(binding) {
			comingSoonIndicator.isVisible = false
			imageView.setImageDrawable(null)
			title.text = null
		}
	}
}