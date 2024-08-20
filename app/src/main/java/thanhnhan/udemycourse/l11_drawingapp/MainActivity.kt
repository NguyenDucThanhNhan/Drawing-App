package thanhnhan.udemycourse.l11_drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import thanhnhan.udemycourse.l11_drawingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.drawingView.setSizeForBrush(20.toFloat())

        binding.btnBlack.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_pressed)
        )

        binding.btnBrush.setOnClickListener {
            showBrushSizeChooserDialog()
        }

        setupButtonClick(binding.btnSkin, ContextCompat.getColor(this, R.color.skin))
        setupButtonClick(binding.btnBlack, ContextCompat.getColor(this, R.color.black))
        setupButtonClick(binding.btnBlue, ContextCompat.getColor(this, R.color.blue))
        setupButtonClick(binding.btnGreen, ContextCompat.getColor(this, R.color.green))
        setupButtonClick(binding.btnLollipop, ContextCompat.getColor(this, R.color.lollipop))
        setupButtonClick(binding.btnRandom, ContextCompat.getColor(this, R.color.random))
        setupButtonClick(binding.btnYellow, ContextCompat.getColor(this, R.color.yellow))
        setupButtonClick(binding.btnRed, ContextCompat.getColor(this, R.color.red))
        setupButtonClick(binding.btnWhite, ContextCompat.getColor(this, R.color.white))

    }

    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallButton = brushDialog.findViewById<ImageButton>(R.id.btn_small_brush)
        smallButton.setOnClickListener {
            binding.drawingView.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        val mediumButton = brushDialog.findViewById<ImageButton>(R.id.btn_medium_brush)
        mediumButton.setOnClickListener {
            binding.drawingView.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        val largeButton = brushDialog.findViewById<ImageButton>(R.id.btn_large_brush)
        largeButton.setOnClickListener {
            binding.drawingView.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()
    }

    private fun resetColorClicked() {
        binding.btnSkin.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnBlack.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnBlue.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnGreen.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnLollipop.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnRandom.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnYellow.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnRed.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
        binding.btnWhite.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )
    }

    private fun setupButtonClick(button: ImageButton, colorRes: Int) {
        button.setOnClickListener {
            resetColorClicked()
            binding.drawingView.setColor(colorRes)
            button.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_pressed))
        }
    }
}